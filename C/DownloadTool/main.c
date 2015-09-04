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



int main(int argc, char *argv[]) {
    
    hashset_t set = hashset_create();
    hashset_add(set,"leer");
    curl_global_init(CURL_GLOBAL_ALL);
    CURL * myHandle = curl_easy_init();
    char md5Password [32];
    struct string s;
    struct string g;
    init_string(&s);
    init_string(&g);
    int i;
    /*
      char password[BUFSIZ];
      char name[BUFSIZ];
      printf("Enter Username: \n");
      fgets(name, BUFSIZ, stdin);
      printf("Enter Password: \n");
      fgets(password,BUFSIZ,stdin);
      cleaner(name);
      cleaner(password);
     */

    //temp
    char password [] = "569dgBAh#6Kv2^e9z^ALFiOq";
    char name [] = "Foxi";

    //temp

    hashPassword(password, md5Password);
    doLogin(name, md5Password, myHandle);

    sleep(3);
    getSecretToken(myHandle,&s);
    sleep(3);

    char* tokenarray = (char*) malloc((s.len + 3) * sizeof (char));

    strcpy(tokenarray, s.ptr);
    findSecretToken(tokenarray, s.len);
    
    //Hier muss die URL hin auf welche Danke gesagt wird!
    char danke [] = "http://usenet-4all.info/forum/showthread.php?t=637647";
    doTanks(danke,&g, myHandle);

    char* pidarray = (char*) malloc((g.len + 3) * sizeof (char));
    strcpy(pidarray, g.ptr);
    findPid(pidarray, g.len, set);
    //Ab hier habe ich alle PIDS!
    pushthanks(tokenarray,danke,set,myHandle);
    
    
    print_cookies(myHandle);
    curl_easy_cleanup(myHandle);

    free(s.ptr);

    free(tokenarray);
    free(pidarray);

    free(g.ptr);


    return 0;
}



static void print_cookies(CURL *curl) {
    CURLcode res;
    struct curl_slist *cookies;
    struct curl_slist *nc;
    int i;

    printf("Cookies, curl knows:\n");
    res = curl_easy_getinfo(curl, CURLINFO_COOKIELIST, &cookies);
    if (res != CURLE_OK) {
        fprintf(stderr, "Curl curl_easy_getinfo failed: %s\n", curl_easy_strerror(res));
        exit(1);
    }
    nc = cookies, i = 1;
    while (nc) {
        printf("[%d]: %s\n", i, nc->data);
        nc = nc->next;
        i++;
    }
    if (i == 1) {
        printf("(none)\n");
    }
    curl_slist_free_all(cookies);
}



