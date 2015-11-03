package com.salesforce.kp.wheresreid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * MainActivity is the primary activity.
 *
 * This activity extends AppCompatActivity to provide the primary interface for user interaction.
 *
 * @author Salesforce (R) 2015.
 */
public class MainActivity extends BaseActivity {

    private WebView markdownView;
    public static boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        prepareDisplay();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Add items to the action bar if present. */
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         * Handles action bar item clicks
         * The action bar automatically handles clicks on the Home/Up button if
         * a parent activity in AndroidManifest.xml has been specified.
         */

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));

        } else if (id == R.id.action_map) {
            startActivity(new Intent(this, MapsActivity.class));
        }
        else if (id == R.id.action_cloudpage_inbox){
            startActivity(new Intent(this, CloudPageInboxActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Loads the webView with project's markdown at github
     */
    private void prepareDisplay(){
        markdownView = (WebView)findViewById(R.id.markdownView);
        markdownView.getSettings().setJavaScriptEnabled(true);
        markdownView.loadUrl(getResources().getString(R.string.readme_remote_url));
        markdownView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
    }
}