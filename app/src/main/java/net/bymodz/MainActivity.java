package net.bymodz;
 
import android.Manifest;
import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.graphics.Typeface;
import android.view.Gravity;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity implements View.OnClickListener{ 
    Native n;
    RelativeLayout root;
    LinearLayout mainlinear;
    
    int[] px = {16,18,24,32};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        n = new Native();
        
        ActionBar actionBar = getActionBar();
        actionBar.setElevation(0);
        actionBar.setTitle(null);
        
        
        final ProgressBar progressbar = new ProgressBar(this,null,android.R.attr.progressBarStyle);
        progressbar.setIndeterminate(true);
        root = findViewById(R.id.mainRelative);
        root.setBackgroundColor(Color.parseColor("#212121"));
        mainlinear = findViewById(R.id.container);
        mainlinear.addView(progressbar);
        
        isGrantSd();
        
        new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    
                    /*===========================*/
                    
                    /*===========================*/
                    String tx = n.gS(0);
                    TextView tn = an(tx.substring(9, 12));
                    root.addView(tn);
                    root.addView(cp());
                    
                    mainlinear.setPadding(Px(px[3]),Px(px[2]),Px(px[3]),Px(px[2]));
                    ((ViewGroup) progressbar. getParent()).removeView(progressbar);
                   
                    LinearLayout.LayoutParams btnparams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    btnparams.setMargins(0,0,0,Px(px[1]));
                    
                    Button b1 = new Button(getApplicationContext());
                    Button b2 = new Button(getApplicationContext());
                    Button b3 = new Button(getApplicationContext());
                    
                    b1.setLayoutParams(btnparams);
                    b2.setLayoutParams(btnparams);
                    b3.setLayoutParams(btnparams);
                    
                    b1.setId(0x190301);
                    b2.setId(0x190402);
                    b3.setId(0x190503);
                    
                    setBtn(b1,n.gS(1),R.color.colorAccent);
                    setBtn(b2,n.gS(2),R.color.colorAccent);
                    setBtn(b3,n.gS(3),R.color.colorOff);
                    
                    b1.setOnClickListener(MainActivity.this);
                    b2.setOnClickListener(MainActivity.this);
                    b3.setOnClickListener(MainActivity.this);
                    
                    mainlinear.addView(b1);
                    mainlinear.addView(b2);
                    mainlinear.addView(b3);
                    
                   
                    n.mT(getBaseContext(),0);
                    
                    
                    /*===========================*/
                    
                    /*===========================*/
                }
            }, 3000);                    
        
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case 0x190301:
                
                m(n.gS(6),n.gS(11));
                n.mT(getBaseContext(),1);
                break;
                
            case 0x190402:
                
                m(n.gS(7),n.gS(11));
                n.mT(getBaseContext(),2);
                break;
                
            case 0x190503:
                
                m(n.gS(8),n.gS(11));
                n.mT(getBaseContext(),3);
                break;
        }
    }
    /*===========================*/
    
    /*===========================*/
    public void m(String s,String d){
        isGrantSd();
        AssetManager a= getAssets();
        InputStream i = null;
        OutputStream o = null;
        try {
            i = a.open(s);
            File outFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+d);
            o = new FileOutputStream(outFile);
            c(i, o);
            i.close();
            i = null;
            o.flush();
            o.close();
            o = null;
        } catch(IOException e) {
            Toast.makeText(getApplication(),e.getLocalizedMessage().toString(),1).show();
        }

    }
    private void c(InputStream i, OutputStream o) throws IOException {
        byte[] b = new byte[1024];
        int r;
        while((r = i.read(b)) != -1){
            o.write(b, 0, r);
        }
	}
    public boolean d(final String pathname) {
        isGrantSd();
        final File file = new File(pathname);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            file.delete();
            return false;
        }
        final File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (final File file2 : listFiles) {
                if (file2.isDirectory()) {
                    this.d(file2.getAbsolutePath());
                }
                if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
        file.delete();
        return false;
    }
    public  boolean isGrantSd() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                return false;
            }
        }
        else { 
            return true;
        }
	}
    /*===========================*/
    
    /*===========================*/
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        menu.add(menu.NONE,0x1,menu.NONE,n.gS(12));  
        menu.add(menu.NONE,0x2,menu.NONE,n.gS(13));    
        menu.add(menu.NONE,0x3,menu.NONE,n.gS(14));
        
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        String p = Environment.getExternalStorageDirectory().getAbsolutePath();
        switch(item.getItemId()){
            
            case 0x1:
                AlertDialog.Builder build = new AlertDialog.Builder(this);
                build.setIcon(R.mipmap.ic_launcher);
                build.setTitle(n.gS(0));
                build.setMessage(n.gS(16));
                AlertDialog d = build.create();
                d.show();
                return true;
                
            case 0x2:
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(n.gS(15)));
                startActivity(i);
                return true;
            case 0x3:

                d(p+n.gS(9));
                d(p+n.gS(10));
                n.mT(getApplicationContext(),4);
                
               return true;
               
            default:
                return super.onOptionsItemSelected(item);
        
            }     
        }
    /* ====================== */
    
    public void setBtn(final Button button,String text,int color){

        final GradientDrawable gd1 = new GradientDrawable();
        gd1.setColor(android.R.color.transparent);
        gd1.setCornerRadius(5);
        gd1.setStroke(2,getResources().getColor(color));
        button.setText(text);
        button.setTextColor(Color.WHITE);
        button.setBackgroundDrawable(gd1);
        button.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        //Button Pressed
                        GradientDrawable gd = new GradientDrawable();
                        gd.setColor(getResources().getColor(R.color.colorAccent));
                        gd.setCornerRadius(5);
                        gd.setStroke(2, android.R.color.white);
                        button.setBackgroundDrawable(gd);
                    }
                    if(event.getAction() == MotionEvent.ACTION_UP){
                        //finger was lifted
                        button.setBackgroundDrawable(gd1);
                    }
                    return false;
                }
            });
    }
    
    /* ====================== */
    
    
    public int Px(int px){
        Resources r = getResources();
        int pxs = (int) TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            px, 
            r.getDisplayMetrics()
        );
        return pxs;
	}
    private TextView an(String name){
        
        int marg = Px(14);
        int size = Px(28);
        RelativeLayout.LayoutParams params = new
            RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.setMargins(0,marg,0,0);

        Typeface fonts = Typeface.createFromAsset(getAssets(),n.gS(5));  
        TextView text = new TextView(this);
        text.setLayoutParams(params);
        text.setTextColor(Color.WHITE);
        text.setTextSize(size);
        text.setText(name);
        text.setTypeface(fonts);

        return text;
    }
    private TextView cp(){

        String name = n.gS(4);
        int marg = Px(16);
        
        RelativeLayout.LayoutParams params = new
            RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.setMargins(0,0,0,marg);

        TextView text = new TextView(this);
        text.setLayoutParams(params);
        text.setTextColor(Color.WHITE);
        text.setText(name);
        
        return text;
    }
    
    
}
