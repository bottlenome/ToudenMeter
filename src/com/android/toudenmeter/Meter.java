package com.android.toudenmeter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Meter {
	private String update;
	private String max;
	private String now;
	private int rate;
	
	Meter(String csv)
	{
		this.parse(csv);
	}

	private void parse(String csv)
	{
		BufferedReader br = null;
		String tmp = "";
		try{
			br = new BufferedReader(new StringReader(csv), 1500);
			// ˆês–Ú‚Éupdate
			tmp = br.readLine();
			this.update = tmp.split(" ")[1];
			br.readLine();
			// Os–Ú‚Émax
			tmp = br.readLine();
			this.max = tmp.split(",")[0];
			for(int i = 0; i < 5; i++) {
				br.readLine();
			}
			for(int i = 0; i < 24; i++) {
				tmp = br.readLine();
				tmp = tmp.split(",")[2];
				if(tmp.matches("0"))
					break;
				this.now = tmp;
			}
			this.rate = (Integer.valueOf(this.now)*100) / Integer.valueOf(this.max); 
		}
		catch(Exception e)
		{
		}
		finally
		{
			
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public String getUpdate() {
		return update;
	}

	public String getMax() {
		return max;
	}

	public String getNow() {
		return now;
	}

	public int getRate() {
		return rate;
	}
}
