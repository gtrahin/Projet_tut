package gael.projet_tut_v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;


public class MainActivity extends Activity {

    public ImageButton butGeo;
    public ImageButton butFiches;
    public ImageButton butLienUtiles;
    public ImageButton butUrgence;
    public ImageButton butAutre;

    public  ButtonListener buttonListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        createWidget();
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
