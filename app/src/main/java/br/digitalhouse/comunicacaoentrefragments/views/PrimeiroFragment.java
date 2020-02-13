package br.digitalhouse.comunicacaoentrefragments.views;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import br.digitalhouse.comunicacaoentrefragments.R;
import br.digitalhouse.comunicacaoentrefragments.interfaces.Comunicador;
import br.digitalhouse.comunicacaoentrefragments.model.SistemaOperacional;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiroFragment extends Fragment {

    private Comunicador comunicador;
    private Button botaoAndroid;
    private Button botaoIos;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        comunicador = (Comunicador) context; //não dá BO porque a mainActivity implementa a interface comunicador
    }

    public PrimeiroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primeiro, container, false);

        initViews(view);

        botaoAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SistemaOperacional sistemaOperacional = new SistemaOperacional("ANDROID", R.drawable.android);

                comunicador.envioDadosSistemaOperaciona(sistemaOperacional);

            }
        });

        return view;
    }

    private void initViews (View view){
        botaoAndroid = view.findViewById(R.id.button1);
        botaoIos = view.findViewById(R.id.button2);
    }

}
