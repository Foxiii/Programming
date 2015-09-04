#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <curl/curl.h>
#include <curl/easy.h>
#include <string.h>
#include <ctype.h>
#include <string.h>
#include<regex.h>
#include <openssl/md5.h>
#include "headers.h"

void hashPassword(char* clearText, char* mdSet){
     
    
    char temp [strlen(clearText)+1];
    int c;
    
    for(c=0;c <= strlen(clearText);c++){
        if(c == strlen(clearText)){
            temp[c] = '\0';
        }
        temp[c] = clearText[c];
    }
    
    unsigned char digest[MD5_DIGEST_LENGTH];
    MD5((unsigned char*) &temp, strlen(temp), (unsigned char*) &digest);
    int i;
    char* mdString = (char*) malloc(33 * sizeof (char));
    for (i = 0; i < 16; i++)
        sprintf(&mdString[i * 2], "%02x", (unsigned int) digest[i]);
    
    strcpy(mdSet,mdString);
    free(mdString);
   
}