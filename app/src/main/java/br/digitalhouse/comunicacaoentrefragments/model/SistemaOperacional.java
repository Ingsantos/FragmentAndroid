package br.digitalhouse.comunicacaoentrefragments.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SistemaOperacional implements Parcelable {
    //necessário utilizar a interface parcelabel para poder usar ela na main, e compactar o objeto
    private String nomeSistema;
    private int imagem;

    public SistemaOperacional(String nomeSistema, int imagem) {
        this.nomeSistema = nomeSistema;
        this.imagem = imagem;
    }

    protected SistemaOperacional(Parcel in) {
        nomeSistema = in.readString();
        imagem = in.readInt();
    }

    public static final Creator<SistemaOperacional> CREATOR = new Creator<SistemaOperacional>() {
        @Override
        public SistemaOperacional createFromParcel(Parcel in) {
            return new SistemaOperacional(in);
        }

        @Override
        public SistemaOperacional[] newArray(int size) {
            return new SistemaOperacional[size];
        }
    };

    public String getNomeSistema() {
        return nomeSistema;
    }

    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nomeSistema);
        parcel.writeInt(imagem);
    }
}
