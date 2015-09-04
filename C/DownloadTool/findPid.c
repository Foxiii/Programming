#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "headers.h"
#include "hashset.h"

void findPid(char* value, int size, hashset_t set) {
   

    int i;
    int string;
    char token [] = "return !thanks_do(";
    char *sid = (char*)malloc((20) * sizeof (char));

    while (1==1) {
        if (strstr(value, token)) {
            char *begin = strstr(value, token);
            
            for (i = 0; i < 8; i++) {
                if (begin[i + 18] == ')') {
                    sid[i] = '\0';
                    continue;
                }
                sid[i] = begin[i + 18];
            }
            string = atoi(sid);
            hashset_add(set, string);
            value = begin;
            value++;
            
        }else{
           
            break;
        }
        
    }

free(sid);

}

void doTanks(char* url, struct string *g ,CURL* myHandle){
    curl_easy_setopt(myHandle, CURLOPT_URL, url);
    
    curl_easy_setopt(myHandle, CURLOPT_USERAGENT, "Mozilla/4.0");
    curl_easy_setopt(myHandle, CURLOPT_AUTOREFERER, 1);
    curl_easy_setopt(myHandle, CURLOPT_FOLLOWLOCATION, 1);
    curl_easy_setopt(myHandle, CURLOPT_COOKIESESSION, 1);
    curl_easy_setopt(myHandle, CURLOPT_WRITEFUNCTION, writefunc);
    curl_easy_setopt(myHandle, CURLOPT_WRITEDATA, g);
    // curl_easy_setopt(myHandle, CURLOPT_POSTFIELDS, token);
    
    curl_easy_perform(myHandle);
    
}

void getSecretToken(CURL* myHandle, struct string* s){
    curl_easy_setopt(myHandle, CURLOPT_HTTPGET, "http://usenet-4all.info/forum/search.php?do=getnew");
    curl_easy_setopt(myHandle, CURLOPT_URL, "http://usenet-4all.info/forum/search.php?do=getnew");
    curl_easy_setopt(myHandle, CURLOPT_REFERER, "http://usenet-4all.info/forum/search.php?do=getnew");
    curl_easy_setopt(myHandle, CURLOPT_WRITEFUNCTION, writefunc);
    curl_easy_setopt(myHandle, CURLOPT_WRITEDATA, s);
    curl_easy_perform(myHandle);
}
    