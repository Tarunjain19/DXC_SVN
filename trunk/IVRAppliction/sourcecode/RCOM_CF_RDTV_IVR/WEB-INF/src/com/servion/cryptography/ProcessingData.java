package com.servion.cryptography;

//Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
//Jad home page: http://www.kpdus.com/jad.html
//Decompiler options: packimports(3) 
//Source File Name:   Encoder.java


class ProcessingData
{

 ProcessingData()
 {
     strLengthOfPin = 0;
     xorseq = 0L;
     fst = 0L;
     scd = 0L;
 }

 protected final long magicNum = 1L;
 int strLengthOfPin;
 long xorseq;
 long fst;
 long scd;
}
