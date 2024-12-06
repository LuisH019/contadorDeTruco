package com.example.contadordetruco;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int countTeam1 = 0;
    int countTeam2 = 0;
    int countVictoriesTeam1 = 0;
    int countVictoriesTeam2 = 0;

    private static final String THEME_PREFS = "themePrefs";
    private static final String SELECTED_THEME = "selectedTheme";

    Button plus1Team1;
    Button minus1Team1;
    Button plus3Team1;
    Button plus6Team1;
    Button plus9Team1;
    Button plus1Team2;
    Button minus1Team2;
    Button plus3Team2;
    Button plus6Team2;
    Button plus9Team2;
    Button zerar;
    Button zerarVitorias;
    ImageButton buttonChangeTheme;

    TextView scoreTeam1;
    TextView scoreTeam2;
    TextView victoriesTeam1;
    TextView victoriesTeam2;

    EditText nameTeam1;
    EditText nameTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences(THEME_PREFS, MODE_PRIVATE);
        int themeId = preferences.getInt(SELECTED_THEME, R.style.Theme_ContadorDeTruco_Mesa_Verde);
        setTheme(themeId);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus1Team1 = (Button) findViewById(R.id.plus1Team1);
        minus1Team1 = (Button) findViewById(R.id.minus1Team1);
        plus3Team1 = (Button) findViewById(R.id.plus3Team1);
        plus6Team1 = (Button) findViewById(R.id.plus6Team1);
        plus9Team1 = (Button) findViewById(R.id.plus9Team1);
        plus1Team2 = (Button) findViewById(R.id.plus1Team2);
        minus1Team2 = (Button) findViewById(R.id.minus1Team2);
        plus3Team2 = (Button) findViewById(R.id.plus3Team2);
        plus6Team2 = (Button) findViewById(R.id.plus6Team2);
        plus9Team2 = (Button) findViewById(R.id.plus9Team2);
        zerar = (Button) findViewById(R.id.zerar);
        zerarVitorias = (Button) findViewById(R.id.zerarVitorias);
        buttonChangeTheme = (ImageButton) findViewById(R.id.buttonChangeTheme);

        scoreTeam1 = (TextView) findViewById(R.id.scoreTeam1);
        scoreTeam2 = (TextView) findViewById(R.id.scoreTeam2);
        victoriesTeam1 = (TextView) findViewById(R.id.victoriesTeam1);
        victoriesTeam2 = (TextView) findViewById(R.id.victoriesTeam2);

        nameTeam1 = (EditText) findViewById(R.id.nameTeam1);
        nameTeam2 = (EditText) findViewById(R.id.nameTeam2);

        TextView currentThemeTextView = findViewById(R.id.currentThemeTextView);
        currentThemeTextView.setText(getCurrentThemeName(themeId));


        plus1Team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusOneTeamOne();
                setScoreTeam1();
                winCondition();
            }
        });
        minus1Team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minusOneTeamOne();
                setScoreTeam1();
            }
        });
        plus3Team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusThreeTeamOne();
                setScoreTeam1();
                winCondition();
            }
        });
        plus6Team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusSixTeamOne();
                setScoreTeam1();
                winCondition();
            }
        });
        plus9Team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusNineTeamOne();
                setScoreTeam1();
                winCondition();
            }
        });
        plus1Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusOneTeamTwo();
                setScoreTeam2();
                winCondition();
            }
        });
        minus1Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minusOneTeamTwo();
                setScoreTeam2();
            }
        });
        plus3Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusThreeTeamTwo();
                setScoreTeam2();
                winCondition();
            }
        });
        plus6Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusSixTeamTwo();
                setScoreTeam2();
                winCondition();
            }
        });
        plus9Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusNineTeamTwo();
                setScoreTeam2();
                winCondition();
            }
        });
        zerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zerar();
                setScoreTeam1();
                setScoreTeam2();

            }
        });
        zerarVitorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zerarVitorias();
                setVictoriesTeam1();
                setVictoriesTeam2();

            }
        });
        buttonChangeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showThemeSelectionDialog();
            }
        });
        victoriesTeam1.setVisibility(View.VISIBLE);

    }
    public void plusOneTeamOne(){
        countTeam1 +=1;
    }
    public void minusOneTeamOne(){
        if (countTeam1 > 0){
            countTeam1 -=1;
        }
    }
    public void plusThreeTeamOne(){
        countTeam1 +=3;
    }
    public void plusSixTeamOne(){
        countTeam1 +=6;
    }
    public void plusNineTeamOne(){
        countTeam1 +=9;
    }
    public void plusOneTeamTwo(){
        countTeam2 +=1;
    }
    public void minusOneTeamTwo(){
        if (countTeam2 >0){
            countTeam2 -=1;
        }
    }
    public void plusThreeTeamTwo(){
        countTeam2 +=3;
    }
    public void plusSixTeamTwo(){
        countTeam2 +=6;
    }
    public void plusNineTeamTwo(){
        countTeam2 +=9;
    }
    public void plusVictoriesTeamOne(){ countVictoriesTeam1 +=1;}
    public void plusVictoriesTeamTwo(){ countVictoriesTeam2 +=1;}


    public void setScoreTeam1(){
        String strCountTeam1 = String.valueOf(countTeam1);
        scoreTeam1.setText(strCountTeam1);
    }
    public void setScoreTeam2(){
        String strCountTeam2 = String.valueOf(countTeam2);
        scoreTeam2.setText(strCountTeam2);
    }
    public void setVictoriesTeam1(){
        String strCountTeam1 = String.valueOf(countVictoriesTeam1);
        victoriesTeam1.setText(strCountTeam1);
    }
    public void setVictoriesTeam2(){
        String strCountTeam2 = String.valueOf(countVictoriesTeam2);
        victoriesTeam2.setText(strCountTeam2);
    }
    public void zerar(){
        countTeam1 = 0;
        countTeam2 = 0;
    }
    public void zerarVitorias(){
        countVictoriesTeam1 = 0;
        countVictoriesTeam2 = 0;
    }
    public void winCondition(){
        AlertDialog.Builder caixaDialogo = new AlertDialog.Builder(this);
        caixaDialogo.setCancelable(false);

        if(countTeam1 >= 12){
            caixaDialogo.setMessage(nameTeam1.getText().toString()+" venceu!").setPositiveButton("recomeçar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    zerar();
                    setScoreTeam1();
                    setScoreTeam2();
                    plusVictoriesTeamOne();
                    setVictoriesTeam1();
                }
            });
            caixaDialogo.show();

        }else if(countTeam2 >= 12){
            caixaDialogo.setMessage(nameTeam2.getText().toString()+" venceu!").setPositiveButton("recomeçar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    zerar();
                    setScoreTeam1();
                    setScoreTeam2();
                    plusVictoriesTeamTwo();
                    setVictoriesTeam2();
                }
            });;
            caixaDialogo.show();
        }

        Dialog dialogo = caixaDialogo.create();
        dialogo.setCanceledOnTouchOutside(false);
    }

    private void showThemeSelectionDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_select_theme);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialog.findViewById(R.id.buttonMadeiraTheme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Theme_ContadorDeTruco_Madeira);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.buttonMesaVerdeTheme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Theme_ContadorDeTruco_Mesa_Verde);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.buttonDarkTheme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Theme_ContadorDeTruco_Dark);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.buttonLightTheme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Theme_ContadorDeTruco_Light);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.buttonGreenTheme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Theme_ContadorDeTruco_Green);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.buttonPurpleTheme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Theme_ContadorDeTruco_Purple);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.buttonRedTheme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTheme(R.style.Theme_ContadorDeTruco_Red);
                dialog.dismiss();
            }
        });



        dialog.show();
    }

    private void changeTheme(int themeId) {
        SharedPreferences.Editor editor = getSharedPreferences(THEME_PREFS, MODE_PRIVATE).edit();
        editor.putInt(SELECTED_THEME, themeId);
        editor.apply();

        recreate();
    }

    private String getCurrentThemeName(int themeId) {
        switch (themeId) {
            case R.style.Theme_ContadorDeTruco_Madeira:
                return "Madeira";
            case R.style.Theme_ContadorDeTruco_Mesa_Verde:
                return "Mesa de Baralho";
            case R.style.Theme_ContadorDeTruco_Dark:
                return "Escuro";
            case R.style.Theme_ContadorDeTruco_Light:
                return "Claro";
            case R.style.Theme_ContadorDeTruco_Green:
                return "Verde";
            case R.style.Theme_ContadorDeTruco_Purple:
                return "Roxo";
            case R.style.Theme_ContadorDeTruco_Red:
                return "Vermelho";
            default:
                return "Unknown Theme";
        }
    }
}