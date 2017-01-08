package com.matiaslevyhara.languageconverter;

import android.support.v7.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@SuppressLint("NewApi")
	public void OnClick(View v){
		String output="";
		String vowels="aeiou";
		EditText textInput = (EditText)findViewById(R.id.textInput);
		TextView display = (TextView)findViewById(R.id.display);
		String input = textInput.getText().toString();
		String space=" ";
		if (v.getId()==R.id.Rovarspraket){
			String letter;
			output="";
			for (int i=0;i<input.length();i++){
				letter = input.substring(i,i+1);
				if (letter.equals(space)){ //space
					output+=space;
				}
				else if (vowels.indexOf(letter)==-1){ //consonant
					output+=letter+"o"+letter;
				}
				else if (vowels.indexOf(letter)!=-1){ //vowel
					output+=letter;
				}
			}
			display.setText(output);
		}
		if (v.getId()==R.id.PigLatin){
			output="";
			String letter,suffix="",firstLetter=input.substring(0,1);
			if (vowels.indexOf(firstLetter)==-1){
				output=input.replace(firstLetter, "");
				suffix="ay";
			}
			else if (vowels.indexOf(firstLetter)!=-1){
				suffix="way";
			}
			for (int i=0;i<input.length();i++){
				letter = input.substring(i,i+1);
				if (letter.equals(space)){ //space
					output+=suffix+space;
					firstLetter=input.substring(i++,i+2);
					if (vowels.indexOf(firstLetter)==-1){ //consonant
						output+=input.replace(firstLetter, "");
						suffix="ay";
					}
					else if (vowels.indexOf(firstLetter)!=-1){ //vowel
						suffix="way";
					}
				}
			}
			display.setText(output);
		}
		if (v.getId()==R.id.Jargon){
			output="";
			String letter,aWord="adaga",eWord="edegue",iWord="idigi",oWord="odogo",uWord="udugu";
			for (int i=0;i<input.length();i++){
				letter = input.substring(i,i+1);
				if (letter.equals(space)){ //space
					output+=space;
				}
				else if (vowels.indexOf(letter)==-1){ //consonant
					output+=letter;
				}
				else if (vowels.indexOf(letter)!=-1){ //vowel
					if (iWord.indexOf(letter)!=-1){
						output+=iWord;
					}
					else if (eWord.indexOf(letter)!=-1){
						output+=eWord;
					}
					else if (aWord.indexOf(letter)!=-1){
						output+=aWord;
					}
					else if (oWord.indexOf(letter)!=-1){
						output+=oWord;
					}
					else if (uWord.indexOf(letter)!=-1){
						output+=uWord;
					}
				}
			}
			display.setText(output);
		}
		if (v.getId()==R.id.UbbiDubbi){
			output="";
			String letter;
			boolean doubleVowel=false;
			for (int i=0;i<input.length();i++){
				letter = input.substring(i,i+1);
				if (letter.equals(space)){ //space
					output+=space;
				}
				else if (vowels.indexOf(letter)==-1){ //consonant
					output+=letter;
					doubleVowel=false;
				}
				else if (vowels.indexOf(letter)!=-1){ //vowel
					if (!doubleVowel){
						output+="ob"+letter;
						doubleVowel=true;
					}
				}
			}
			display.setText(output);
		}
		if (v.getId()==R.id.Jeringozo){
			output="";
			String letter;
			boolean doubleVowel=false;
			for (int i=0;i<input.length();i++){
				letter = input.substring(i,i+1);
				if (letter.equals(space)){ //space
					output+=space;
				}
				else if (vowels.indexOf(letter)==-1){ //consonant
					output+=letter;
					doubleVowel=false;
				}
				else if (vowels.indexOf(letter)!=-1){ //vowel
					if (!doubleVowel){
						output+=letter+"p"+letter;
						doubleVowel=true;
					}
				}
			}
			display.setText(output);
		}
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
}
