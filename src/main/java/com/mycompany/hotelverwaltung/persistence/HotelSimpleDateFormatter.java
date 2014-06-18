/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.hotelverwaltung.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author said
 */
public class HotelSimpleDateFormatter{
    
    private SimpleDateFormat simpleDateFormat;
    private static final String EE_MMM_DD_H_HMMSS_Z_YYYY = "EE MMM dd HH:mm:ss z yyyy";
    
    public HotelSimpleDateFormatter(){
        this.simpleDateFormat=new SimpleDateFormat(EE_MMM_DD_H_HMMSS_Z_YYYY, Locale.ENGLISH);
    }
    
    public Date parse(String s) throws ParseException{
        return this.simpleDateFormat.parse(s);
    }
    
    public String format(Date date){
        return this.simpleDateFormat.format(date);
    }
    
}
