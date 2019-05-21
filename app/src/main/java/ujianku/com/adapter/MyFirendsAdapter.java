package ujianku.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ujianku.com.R;
import ujianku.com.model.FriendsModel;


/*
* Nim : 10116093
* Nama : Yusup Maulanadireja
* Kelas : IF-3/AKB-3
* Tanggal Pengerjaan : 19 Mei 2019
* */
public class MyFirendsAdapter extends RecyclerView.Adapter<MyFirendsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<FriendsModel>friendsModels;

    public MyFirendsAdapter(Context context, ArrayList<FriendsModel> friendsModels) {
        this.context = context;
        this.friendsModels = friendsModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friends, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        FriendsModel friendsModel = friendsModels.get(position);
        holder.txtNim.setText(friendsModel.getNim());
        holder.txtNama.setText(friendsModel.getNama());
        holder.txtKelas.setText(friendsModel.getKelas());
        holder.txtTelp.setText(friendsModel.getTelephone());
        holder.txtEmail.setText(friendsModel.getEmail());
        holder.txtSosmed.setText("instagram : "+friendsModel.getSosmed());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(v,context,position,friendsModel.getNim(),friendsModel.getNama(),friendsModel.getKelas(),friendsModel.getTelephone(),friendsModel.getEmail(),friendsModel.getSosmed());
            }
        });
    }


    public void removeItem(int position) {
        friendsModels.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, friendsModels.size());
    }

    private void openDialog(View view,Context context,int position,String nim,String nama,String kelas,String telp,String email,String sosmed){
        ViewGroup viewGroup = view.findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.item_dialog_edit, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);

        TextInputEditText etNim = (TextInputEditText) dialogView.findViewById(R.id.et_nim);
        TextInputEditText etNama = (TextInputEditText) dialogView.findViewById(R.id.et_nama);
        TextInputEditText etKelas = (TextInputEditText) dialogView.findViewById(R.id.et_kelas);
        TextInputEditText etTelp = (TextInputEditText) dialogView.findViewById(R.id.et_tlp);
        TextInputEditText etEmail = (TextInputEditText) dialogView.findViewById(R.id.et_email);
        TextInputEditText etSosmed = (TextInputEditText) dialogView.findViewById(R.id.et_sosmed);
        MaterialButton btnUbah = (MaterialButton) dialogView.findViewById(R.id.btn_ubah);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        etNim.setText(nim);
        etNama.setText(nama);
        etKelas.setText(kelas);
        etTelp.setText(telp);
        etEmail.setText(email);
        etSosmed.setText(sosmed);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNim.getText() != null
                        && etNama.getText().toString() != null
                        && etKelas.getText().toString() != null
                        && etTelp.getText().toString() != null
                        && etEmail.getText().toString() != null
                        && etSosmed.getText().toString() != null){
                    friendsModels.set(position,new FriendsModel(etNim.getText().toString(),etNama.getText().toString(),etKelas.getText().toString(),etTelp.getText().toString(),etEmail.getText().toString(),etSosmed.getText().toString()));
                    notifyItemChanged(position,friendsModels);
                    alertDialog.dismiss();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return friendsModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_nim)
        TextView txtNim;
        @BindView(R.id.txt_nama)
        TextView txtNama;
        @BindView(R.id.txt_kelas)
        TextView txtKelas;
        @BindView(R.id.txt_tlp)
        TextView txtTelp;
        @BindView(R.id.txt_email)
        TextView txtEmail;
        @BindView(R.id.txt_sosmed)
        TextView txtSosmed;
        @BindView(R.id.btn_delete)
        ImageView btnDelete;
        @BindView(R.id.btn_edit)
        ImageView btnEdit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
