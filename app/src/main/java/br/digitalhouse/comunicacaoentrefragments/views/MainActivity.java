package br.digitalhouse.comunicacaoentrefragments.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import br.digitalhouse.comunicacaoentrefragments.R;
import br.digitalhouse.comunicacaoentrefragments.interfaces.Comunicador;
import br.digitalhouse.comunicacaoentrefragments.model.SistemaOperacional;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Comunicador {

    public static final String SISTEMA_OPERACIONAL = "SO"; //chave -> constante, não muda,

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragments(R.id.container2, new PrimeiroFragment());
    }

    @Override
    public void envioDadosSistemaOperaciona(SistemaOperacional sistemaOperacional) {
        Bundle bundle = new Bundle();

        bundle.putParcelable(SISTEMA_OPERACIONAL, sistemaOperacional); //para enviar objetos

        Fragment segundoFragmento = new SegundoFragment();

        segundoFragmento.setArguments(bundle); //em activity usamos setIntentExtra em fragment usamos setArguments

        replaceFragments(R.id.container1, segundoFragmento);

    }

    private void replaceFragments(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();

    }
}
