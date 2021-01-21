package com.example.android.theorem_de_pythagore;
/**imports*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * definition global des variables de l'xml activity
     */

    EditText num;
    EditText num1;
    Button calculdirect;
    Button calculrecipro ;
    TextView display;
    Spinner spinner;
    ClipboardManager clipboard;

    /**
     * definition global des variables du java activity
     */
    double resultat ;
    double to_calculate;
    double AB;
    double AC;
    double BC;
    double exponent;
    String retured;
    String convDouble;
    String role;
    String ab;
    String ac;
    String bc;
    String show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**inflating the varibles above*/

        num = (EditText) findViewById(R.id.num);
        num1 = (EditText) findViewById(R.id.num2);
        calculdirect = (Button) findViewById(R.id.calEx);
        calculrecipro = (Button) findViewById(R.id.calRO);
        display = (TextView) findViewById(R.id.display);
        spinner = (Spinner) findViewById(R.id.spinner);

        /**TODO changing the editText fields hint  for each item selected and blanking text on new item selected*/
        /**and giving a condition for the methods */
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    role = "BC";
                    num.setHint("AC");
                    num.setText("");
                    num1.setHint("AB");
                    num1.setText("");

                }
                if (i == 1) {
                    role = "AC";
                    num.setHint("BC");
                    num.setText("");
                    num1.setHint("AB");
                    num1.setText("");

                }
                if (i == 2) {
                    role = "AB";
                    num.setHint("BC");
                    num.setText("");
                    num1.setHint("AC");
                    num1.setText("");
                }
            }

           /**TODO nothing*/
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        })
        ;
        /**quand le button est clické appeler la methode dont la condition est effectuée */
    calculdirect.setOnClickListener(new View.OnClickListener() {
     @Override
         public void onClick(View view) {
         if (role.contentEquals("AB")){
         try {
             BC = Double.parseDouble(num.getText().toString());
             AC = Double.parseDouble(num1.getText().toString());
         }catch (Exception z){
             Toast.makeText(getBaseContext(), R.string.enter_un_nombre, Toast.LENGTH_SHORT).show();
         }
         calcAB(BC,AC);

     }
         if (role.contentEquals("BC")){
             try {
                 AB = Double.parseDouble(num.getText().toString());
                 AC = Double.parseDouble(num1.getText().toString());
             }catch (Exception z){
                 Toast.makeText(getBaseContext(), R.string.enter_un_nombre, Toast.LENGTH_SHORT).show();
             }
             calcBC(AB,AC);
         }
         if (role.contentEquals("AC")){
            try {
                BC = Double.parseDouble(num.getText().toString());
                AB = Double.parseDouble(num1.getText().toString());
            }catch (Exception z){
                Toast.makeText(getBaseContext(), "R.string.enter_un_nombre", Toast.LENGTH_SHORT).show();
            }
            calcAC(BC,AB);
        }
         show = String.valueOf(resultat);
         display.setText(show);
         Log.v("ana hona ",show);
     }});

calculrecipro.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(getBaseContext(),MainActivity3.class);
        startActivity(i);
    }
});
display.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        copy_text();
        return false;
    }
});


    }
























    /** TODO: appliquer la propriété directe de pythagore et la propriété réciproque de pythagore */
    public void calculer_la_puissance(View view) {

        retured = num.getText().toString();/**convert the edit text output into a String*/

        try {

            /**try to convert returned output into an integer*/

            to_calculate = Double.parseDouble(retured);
        } catch (Exception e) {

            /**if the input wasn't an integer show this toast */

            Toast.makeText(getBaseContext(), "enter an integer", Toast.LENGTH_SHORT).show();
        }
        /** type : double TODO calculer la puissance  */

        exponent = Math.pow(to_calculate, 2);

        /**convertir en String*/

        convDouble = Double.toString(exponent);

        /**it set the text in the text view*/

        display.setText(convDouble);
    }
    public void calculer_la_racine(View view) {

        retured = num.getText().toString();/**convert the edit text output into a String*/

        try {

            /**try to convert returned output into an integer*/

            to_calculate = Double.parseDouble(retured);
        } catch (Exception e) {

            /**if the input wasn't an integer show this toast */

            Toast.makeText(getBaseContext(), "enter an integer", Toast.LENGTH_SHORT).show();
        }
        /** type : double TODO calculer la racine  */

        exponent = Math.sqrt(to_calculate);

        /**convertir en String*/

        convDouble = Double.toString(exponent);

        /**it set the text in the text view*/

        display.setText(convDouble);
    }
    public void copy_text (){
        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("nombre finale",show);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getBaseContext(), R.string.le_resultat_est_copié,Toast.LENGTH_SHORT).show();
    }

    public double calcBC(double AB, double AC){

        if (role.contentEquals("BC")){
            AB = Math.pow(AB,2);
            AC = Math.pow(AC,2);
            resultat = AB+AC;
            resultat = Math.sqrt(resultat);
            bc = String.valueOf(resultat);
           // display.setText(bc);
        }
        return resultat;
    }
    public double calcAC(double BC, double AB){

        if (role.contentEquals("AC")){
            BC = Math.pow(BC,2);
            AB = Math.pow(AB,2);
            resultat = BC-AB;
            resultat = Math.sqrt(resultat);
            ac = String.valueOf(resultat);
            //display.setText(ac);
        }
        return resultat;
    }
    public double calcAB(double BC, double AC){

            BC = Math.pow(BC,2);
            AC = Math.pow(AC,2);
            resultat = BC-AC;
            resultat = Math.sqrt(resultat);
            ab = String.valueOf(resultat);
           // display.setText(ab);
        return resultat;

    }
    public void toast_pour_les_stupides(View view){
     Toast.makeText(getBaseContext(),"entrer le valeur du côté",Toast.LENGTH_SHORT).show();
    }
}