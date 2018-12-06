package com.asis.myasis;

import android.os.Parcel;
import android.os.Parcelable;

public class Absensi implements Parcelable{

    private String tangga;
    private String waktu;
    private int image;

    public Absensi(String tangga, String waktu, int image) {

        this.tangga = tangga;
        this.waktu = waktu;
        this.image = image;
    }


    protected Absensi(Parcel in) {
        tangga = in.readString();
        waktu = in.readString();
        image = in.readInt();
    }

    public static final Creator<Absensi> CREATOR = new Creator<Absensi>() {
        @Override
        public Absensi createFromParcel(Parcel in) {
            return new Absensi(in);
        }

        @Override
        public Absensi[] newArray(int size) {
            return new Absensi[size];
        }
    };

    public String getTangga() {
        return tangga;
    }

    public String getWaktu() {
        return waktu;
    }
    public int getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tangga);
        dest.writeString(waktu);
        dest.writeInt(image);
    }
}
