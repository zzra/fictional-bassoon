package com.example.whatshouldiwear;
/** initial screen of application showing a suggested outfit
 *
 * @author Peter Saunders
 * @version 1.0
 */
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends FragmentActivity {

    // private members
    private View personhead;
    private View persontop;
    private View personbottom;

    // global intents for changing activity
    private Intent intentHead;
    private Intent intentTop;
    private Intent intentBottom;

    /**
     * param bundle for use in switching layouts and reloading activity
     * @param savedInstanceState place to store params on activity reload
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fill members
        personhead = findViewById(R.id.personhead);
        persontop = findViewById(R.id.persontop);
        personbottom = findViewById(R.id.personbottom);

        // create position listener and place
        PositionListener positionListener = new PositionListener();
        personhead.setOnClickListener(positionListener);
        persontop.setOnClickListener(positionListener);
        personbottom.setOnClickListener(positionListener);

        // store intents
        intentHead = new Intent(this, EditHead.class);
        intentTop = new Intent(this, EditTop.class);
        intentBottom = new Intent(this, EditBottom.class);
    }

    // custom listener for items
    class PositionListener implements OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.personhead:
                    startActivity(intentHead);
                    break;
                case R.id.persontop:
                    startActivity(intentTop);
                    break;
                case R.id.personbottom:
                    startActivity(intentBottom);
                    break;
            }
        }
    }
}