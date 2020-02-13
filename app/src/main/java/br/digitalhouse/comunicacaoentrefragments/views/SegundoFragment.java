package br.digitalhouse.comunicacaoentrefragments.views;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import br.digitalhouse.comunicacaoentrefragments.R;
import br.digitalhouse.comunicacaoentrefragments.model.SistemaOperacional;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static br.digitalhouse.comunicacaoentrefragments.views.MainActivity.SISTEMA_OPERACIONAL;


/**
 * A simple {@link Fragment} subclass.
 */
public class SegundoFragment extends Fragment {

    private ImageView imageView;
    private TextView nomeSistema;


    public SegundoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        initViews(view);

        if (getArguments() != null){
            Bundle bundle = getArguments();

            SistemaOperacional sistemaOperacional = bundle.getParcelable(SISTEMA_OPERACIONAL);
            nomeSistema.setText(sistemaOperacional.getNomeSistema());

            //Nova instancia de um objeto drawable
            Drawable drawable = getResources().getDrawable(sistemaOperacional.getImagem());

            //Setando a imagem para o componente ImageView
            imageView.setImageDrawable(drawable);
        }

        return view;
    }

    private void initViews (View view){
        imageView = view.findViewById(R.id.imageView);
        nomeSistema = view.findViewById(R.id.textView);
    }

}
