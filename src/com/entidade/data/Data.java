package com.entidade.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Data {
	private Calendar data;
	private SimpleDateFormat sdf;
	
	public Data() {
		this.data = Calendar.getInstance();
		this.sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	}
	
	public int diferencaDeMinutos(Data dataPosterior) {		 //flexibilizar utilizando parametro (Um enum)
		int min;
		int minIn = data.get(Calendar.MINUTE);
		int minFim = dataPosterior.data.get(Calendar.MINUTE);
		
		if (minIn <= minFim) {
			min = minFim - minIn;			//ex) 8(in)  a 10(fim) = 2 minutos
		} else {
			min = 60 - minIn + minFim;	    //ex) 59(in) a 9(fin) = 10 minutos
		}	
		
		return min;
	}
	
	@Override
	public String toString() {
		return sdf.format(data.getTime());
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( !(obj instanceof Data) ) return false;
		if ( this == obj )			  return true;
		
		Data dt = (Data) obj;
		return (data.equals(dt.data) && sdf.equals(dt.sdf));
	}

}




/*Implementar questões de Localidade*/
