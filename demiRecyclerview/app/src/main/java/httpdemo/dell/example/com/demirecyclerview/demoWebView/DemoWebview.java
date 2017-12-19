package httpdemo.dell.example.com.demirecyclerview.demoWebView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import httpdemo.dell.example.com.demirecyclerview.R;

public class DemoWebview extends AppCompatActivity {
EditText mEditText;
    Button mButton;
    WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_webview);

        mEditText=(EditText)findViewById(R.id.url);
        mButton=(Button)findViewById(R.id.get);
        mWebView=(WebView)findViewById(R.id.web);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=mEditText.getText().toString();
                mWebView.setWebViewClient(new WebViewClient());
                mWebView.loadUrl(data);
            }
        });


    }
}
