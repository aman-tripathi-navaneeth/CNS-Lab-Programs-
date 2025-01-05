#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main() 
{ 
    char str[] = "Hello World"; 
    char str1[12]; // Increased size to accommodate null terminator
    int i, len; 
    len = strlen(str); 
    for (i = 0; i < len; i++) 
    { 
        str1[i] = str[i]; 
        printf("%c", str1[i]); 
    } 
    str1[len] = '\0'; // Null-terminate the string
    printf("\n%s\n", str1); // Print the copied string
    return 0; 
} 
// Output:
// Hello World
//
