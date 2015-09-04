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
#include "hashset.h"
#include "hashset_itr.h"


void pushthanks(char* tokenarray,char* url, hashset_t set, CURL* myHandle){
     int i;
   
     hashset_itr_t itr = hashset_iterator(set);
     
    while(hashset_iterator_has_next(itr)){
        char str[8];
         snprintf(str, 8, "%d",hashset_iterator_value(itr) );
        
        
    char token[500];
    for (i = 0; i < 500; i++)token[i] = '\0';
    strcat(token, "do=thanks&postid=");
    strcat(token, str);
    strcat(token, "&securitytoken=");
    strcat(token, tokenarray);
    strcat(token, "&s=");
    
    
    curl_easy_setopt(myHandle, CURLOPT_PROXY,"127.0.0.1:8080");
    curl_easy_setopt(myHandle, CURLOPT_USERAGENT, "Mozilla/4.0");
    curl_easy_setopt(myHandle, CURLOPT_AUTOREFERER, 1);
    curl_easy_setopt(myHandle, CURLOPT_FOLLOWLOCATION, 1);
    curl_easy_setopt(myHandle, CURLOPT_COOKIESESSION, 1);
    curl_easy_setopt(myHandle, CURLOPT_URL, "http://usenet-4all.info/forum/ajax.php");
    curl_easy_setopt(myHandle, CURLOPT_REFERER, url);
    curl_easy_setopt(myHandle, CURLOPT_COOKIEFILE, "cookievb.txt");
    curl_easy_setopt(myHandle, CURLOPT_COOKIEJAR, "cookievb.txt");
    curl_easy_setopt(myHandle, CURLOPT_POSTFIELDS, token);
    
    curl_easy_perform(myHandle);
    hashset_iterator_next(itr);
    }
    
    
   
    
    
    
    
}

