package com.example.practica4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment1 extends Fragment implements View.OnClickListener {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    ImageView img10;
    ImageView img11;
    ImageView img12;
    ImageView img;
    Animation giro;
    GridLayout grid;
    Button empezar;
    Button acabar;
    SoundPool soundPool;
    int pulsar = 2;

    int id2=0;
    ArrayList<Integer> integers = new ArrayList<Integer>();

    HashMap<Integer,Integer> parejas = new HashMap<Integer, Integer>();

    //raw
    MediaPlayer coin;
    MediaPlayer woo;
    MediaPlayer firework;
    MediaPlayer up;

    TextView puntos;
    int cont2=1;


    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }


    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        empezar = (Button) getView().findViewById(R.id.empezar);
        acabar = (Button) getView().findViewById(R.id.acabar);
        img1 = (ImageView)getView().findViewById(R.id.imageButton1);
        img2 = (ImageView)getView().findViewById(R.id.imageButton2);
        img3 = (ImageView)getView().findViewById(R.id.imageButton3);
        img4 = (ImageView)getView().findViewById(R.id.imageButton4);
        img5 = (ImageView)getView().findViewById(R.id.imageButton5);
        img6 = (ImageView)getView().findViewById(R.id.imageButton6);
        img7 = (ImageView)getView().findViewById(R.id.imageButton7);
        img8 = (ImageView)getView().findViewById(R.id.imageButton8);
        img9 = (ImageView)getView().findViewById(R.id.imageButton9);
        img10 = (ImageView)getView().findViewById(R.id.imageButton10);
        img11= (ImageView)getView().findViewById(R.id.imageButton11);
        img12= (ImageView)getView().findViewById(R.id.imageButton12);
        grid = (GridLayout)getView().findViewById(R.id.grid);

        puntos = (TextView)getView().findViewById(R.id.puntos);
        empezar.setOnClickListener(this);
        acabar.setOnClickListener(this);
        giro = AnimationUtils.loadAnimation(getActivity(),R.anim.girar);

        //instancio la musiquita
        coin = MediaPlayer.create(getActivity(), R.raw.mario_coin);
        woo = MediaPlayer.create(getActivity(), R.raw.mario_bros_woo_hoo);
        firework = MediaPlayer.create(getActivity(), R.raw.mario_bros_firework);
        up = MediaPlayer.create(getActivity(), R.raw.mario_bros_1_up);


    }

    public void empezarPartida(){



    }

    public void asignarAnimales(){

        //creo una arraylist donde meter las ids de las imagenes


        if(integers.isEmpty()) {

            integers.add(R.drawable.ciervo);
            integers.add(R.drawable.conejo);
            integers.add(R.drawable.erizo);
            integers.add(R.drawable.oso);
            integers.add(R.drawable.pajaro);
            integers.add(R.drawable.zorro);
            integers.add(R.drawable.ciervo);
            integers.add(R.drawable.conejo);
            integers.add(R.drawable.erizo);
            integers.add(R.drawable.oso);
            integers.add(R.drawable.pajaro);
            integers.add(R.drawable.zorro);

        }
        //la ordeno aleatoriamente
        Collections.shuffle(integers);

        //instacion las variables para cada tipo de imagen
        int ciervo=0;
        int conejo=0;
        int erizo=0;
        int oso=0;
        int pajaro=0;
        int zorro=0;

        for(int i=0;i<integers.size();i++){

            //en una varialbe id meto el nombre del xml
            int id = getResources().getIdentifier("imageButton" + (i+1),"id",getContext().getPackageName());
            //creo una imagen para meter las imgs
            img = (ImageView) getView().findViewById(id);
            //le pongo las imagenes
            img.setImageResource(integers.get(i));
            img.setBackgroundColor(Color.parseColor("#00BFFF"));




            //para filtrar el tipo de imagen pasandole cada uno de ids de las imagenes
            switch (integers.get(i)){

                //si es ciervo
                case R.drawable.ciervo:

                    //si es la primera vez que lo guarde en la variable
                    if(ciervo==0){

                        ciervo=id;

                    }else{

                        //asigno la pareja con el que teniamos antes y el nuevo
                        parejas.put(ciervo,id);
                        parejas.put(id,ciervo);

                    }

                    break;

                case R.drawable.conejo:

                    if(conejo==0){

                        conejo=id;

                    }else{

                        parejas.put(conejo,id);
                        parejas.put(id,conejo);

                    }

                    break;

                case R.drawable.erizo:

                    if(erizo==0){

                        erizo=id;

                    }else{

                        parejas.put(erizo,id);
                        parejas.put(id,erizo);

                    }

                    break;

                case R.drawable.oso:

                    if(oso==0){

                        oso=id;

                    }else{

                        parejas.put(oso,id);
                        parejas.put(id,oso);

                    }

                    break;

                case R.drawable.pajaro:

                    if(pajaro==0){

                        pajaro=id;

                    }else{

                        parejas.put(pajaro,id);
                        parejas.put(id,pajaro);

                    }

                    break;

                case R.drawable.zorro:

                    if(zorro==0){

                        zorro=id;

                    }else{

                        parejas.put(zorro,id);
                        parejas.put(id,zorro);

                    }

                    break;



            }

          // comprobarImagen(id);

        }
        buttonClick();

    }

    public void comprobarImagen(int id){


        if(pulsar%2==0){
            //se ha pulsado una vez
            pulsar++;

           id2=id;

        }else {
            //se ha pulsado por segunda vez
            pulsar++;

                img = (ImageView) getView().findViewById(id);
                ImageView aa = (ImageView) getView().findViewById(id2);

                img.setBackgroundColor(Color.parseColor("#40FF00"));



                for ( Map.Entry<Integer, Integer> entry : parejas.entrySet()) {

                    if(entry.getValue()==id2 && entry.getKey()==id){

                        img.setBackgroundColor(Color.parseColor("#40FF00"));
                        aa.setBackgroundColor(Color.parseColor("#40FF00"));

                        aa.setClickable(false);
                        img.setClickable(false);

                        aa.setAnimation(giro);
                        img.setAnimation(giro);

                        puntos.setText(cont2+"");
                        woo.start();

                        completado();

                        cont2++;

                    }else{

                        firework.start();

                    }



                }




        }

    }

    public void completado(){

        int cont=0;
        for(int i=0;i<12;i++){

            //en una varialbe id meto el nombre del xml
            int id = getResources().getIdentifier("imageButton" + (i+1),"id",getContext().getPackageName());
            //creo una imagen para meter las imgs
            img = (ImageView) getView().findViewById(id);
            //le pongo las imagenes
            if(!img.isClickable()){
                cont++;
            }
            if(cont==11){

                up.start();
            }

        }
    }




    public void buttonClick(){


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img1.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img2.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img3.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img4.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img5.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img6.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img7.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img8.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img9.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img10.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img11.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coin.start();
                img12.setBackgroundColor(Color.parseColor("#000000"));
                comprobarImagen(v.getId());
            }
        });



    }
    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.empezar){

            acabar.setEnabled(true);
            empezar.setEnabled(false);

            empezarPartida();
            asignarAnimales();


        }
        if(v.getId()==R.id.acabar){

            acabar.setEnabled(false);
            empezar.setEnabled(true);

            integers.clear();
            parejas.clear();

            for(int i=0;i<12;i++){

                //en una varialbe id meto el nombre del xml
                int id = getResources().getIdentifier("imageButton" + (i+1),"id",getContext().getPackageName());
                //creo una imagen para meter las imgs
                img = (ImageView) getView().findViewById(id);
                //le pongo las imagenes
                img.setImageResource(0);
                img.setBackgroundColor(Color.parseColor("#FFFFFF"));
                img.setClickable(false);

            }
        }
    }
}