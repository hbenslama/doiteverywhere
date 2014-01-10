package com.audamob.doit.activity;


import java.io.FileInputStream;





import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.audamob.doit.R;
import com.audamob.doit.model.Account;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;


import android.R.string;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.SpeechRecognizer;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.InputFilter.LengthFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView.OnEditorActionListener;
import android.webkit.WebView;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;



import android.util.*;
public class SwipeyTabFragment_1 extends Fragment {
	
	EditText SearchEdit,SearchEditAlbum;
	
	
	
	    public static Fragment newInstance(String title) {
                SwipeyTabFragment_1 f = new SwipeyTabFragment_1();
                Bundle args = new Bundle();
                args.putString("title", title);
                f.setArguments(args);
                
                return f;
        }
	    
       
        ListView ListVideo;
        
    	@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

                ViewGroup root = (ViewGroup) inflater.inflate(R.layout.bio, null);
                final String title = getArguments().getString("title");
                
                
          

            	return root;
           
        	
        }
    	@Override
    	public void onStart() {
    		// TODO Auto-generated method stub
    		super.onStart();
    	}
    	public Account restoreAccount() throws IOException, ClassNotFoundException {
    		FileInputStream fin = new FileInputStream(getActivity().getCacheDir()
    				.getAbsolutePath() + "/account");
    		ObjectInputStream in = new ObjectInputStream(fin);
    		Account object = (Account) in.readObject();
    		in.close();
    		return object;
    	}

    	public void saveAccount(Account s) throws IOException {
    		FileOutputStream fout = new FileOutputStream(getActivity().getCacheDir()
    				.getAbsolutePath() + "/account");
    		ObjectOutputStream out = new ObjectOutputStream(fout);

    		out.writeObject(s);
    		out.close();
    	}

    	
    	  
   	 
       

           	
}