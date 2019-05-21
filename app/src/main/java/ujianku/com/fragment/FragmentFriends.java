package ujianku.com.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ujianku.com.R;
import ujianku.com.adapter.MyFirendsAdapter;
import ujianku.com.model.FriendsModel;
import ujianku.com.view.MainFriends;

/*
 * Nim : 10116093
 * Nama : Yusup Maulanadireja
 * Kelas : IF-3/AKB-3
 * Tanggal Pengerjaan : 19 Mei 2019
 * */

public class FragmentFriends extends Fragment implements MainFriends {

    @BindView(R.id.btn_tambah)
    FloatingActionButton btnTambah;
    @BindView(R.id.rv_friends)
    RecyclerView rvFriends;

    private MyFirendsAdapter myFirendsAdapter;
    private ArrayList<FriendsModel> friendsModels = new ArrayList<>();

    public FragmentFriends() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        friendsModels.add(new FriendsModel("10116095","Chandra Delvano","IF3","082240527813","chandradelvano@gmail.com","delvano"));
        setRecyclerFriends();

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    @Override
    public void setRecyclerFriends() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        myFirendsAdapter = new MyFirendsAdapter(getContext(),friendsModels);


        rvFriends.setItemAnimator(new DefaultItemAnimator());
        rvFriends.setAdapter(myFirendsAdapter);
        rvFriends.setLayoutManager(layoutManager);
    }

    private void openDialog(){
        ViewGroup viewGroup = getView().findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.item_dialog_tambah, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(dialogView);

        TextInputEditText etNim = (TextInputEditText) dialogView.findViewById(R.id.et_nim);
        TextInputEditText etNama = (TextInputEditText) dialogView.findViewById(R.id.et_nama);
        TextInputEditText etKelas = (TextInputEditText) dialogView.findViewById(R.id.et_kelas);
        TextInputEditText etTelp = (TextInputEditText) dialogView.findViewById(R.id.et_tlp);
        TextInputEditText etEmail = (TextInputEditText) dialogView.findViewById(R.id.et_email);
        TextInputEditText etSosmed = (TextInputEditText) dialogView.findViewById(R.id.et_sosmed);
        MaterialButton btnSimpan = (MaterialButton) dialogView.findViewById(R.id.btn_simpan);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNim.getText().toString().equals("")
                && etNama.getText().toString().equals("")
                && etKelas.getText().toString().equals("")
                && etTelp.getText().toString().equals("")
                && etEmail.getText().toString().equals("")
                && etSosmed.getText().toString().equals("")){
                    Toast.makeText(getContext(),"Data tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else{
                    friendsModels.add(new FriendsModel(etNim.getText().toString(),etNama.getText().toString(),etKelas.getText().toString(),etTelp.getText().toString(),etEmail.getText().toString(),etSosmed.getText().toString()));
                    setRecyclerFriends();
                    alertDialog.dismiss();
                }
            }
        });
    }

}
