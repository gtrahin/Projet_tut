package gael.projet_tut_v2;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class FichesDebutantActivity extends Activity {


    public ImageButton butGeo;
    public ImageButton butFiches;
    public ImageButton butLienUtiles;
    public ImageButton butUrgence;
    public ImageButton butAutre;

    public  ButtonListener buttonListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiches_debutant);

        //creation d'un tableau contenant les items (il faudra par la suite changer par des boutons)
        String[] ItemsList = {"Fiche n°1","Fiche n°2","Fiche n°3","Fiche n°4","Fiche n°5","Fiche n°6","Fiche n°7","Fiche n°8","Fiche n°9","Fiche n°10","Fiche n°11"};


        //creation d'un adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, R.layout.items_grid_view_debutant, ItemsList);


        //recuperation de la liste
        GridView listeDesFiches = (GridView)findViewById(R.id.gridFiches);

        //ajout de l'adapter dans la listeView (this->context , R.layout->layout de la listView , puis la liste d'items)
        listeDesFiches.setAdapter(adapter);

        this.init();
        this.createWidget();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void init(){



        butGeo = (ImageButton)findViewById(R.id.butGeo);
        butFiches = (ImageButton)findViewById(R.id.butFiches);
        butLienUtiles = (ImageButton)findViewById(R.id.butLiens);
        butUrgence = (ImageButton)findViewById(R.id.butUrgence);
        butAutre = (ImageButton)findViewById(R.id.butAutres);

        buttonListener = new ButtonListener(this);

    }

    public void createWidget(){

        butGeo.setOnClickListener(buttonListener);
        butFiches.setOnClickListener(buttonListener);
        butLienUtiles.setOnClickListener(buttonListener);
        butUrgence.setOnClickListener(buttonListener);
        butAutre.setOnClickListener(buttonListener);


    }
}
