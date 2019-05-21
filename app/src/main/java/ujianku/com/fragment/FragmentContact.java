package ujianku.com.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ujianku.com.R;

/*
 * Nim : 10116093
 * Nama : Yusup Maulanadireja
 * Kelas : IF-3/AKB-3
 * Tanggal Pengerjaan : 19 Mei 2019
 * */

public class FragmentContact extends Fragment {


    @BindView(R.id.btn_emailContact)
    CardView btnEmail;
    @BindView(R.id.btn_phoneContact)
    CardView btnPhone;
    @BindView(R.id.btn_sosmedContact)
    CardView btnSosmed;

    public FragmentContact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact("yusupdireja@gmail.com","email");
            }
        });


        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact("082240720623","phone");
            }
        });

        btnSosmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact("https://www.instagram.com/yusupmaulana/","sosmed");
            }
        });
    }

    private void openContact(String uri,String kategori){
        if (kategori.equals("sosmed")){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
        }else if (kategori.equals("email")){
            startActivity(new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:"+uri)));
        }else if (kategori.equals("phone")){
            startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+uri)));
        }

    }

}
