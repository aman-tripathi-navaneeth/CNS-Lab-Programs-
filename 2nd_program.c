#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main() 
{
    char str[] = "Hello World";
    char str1[11];
    char str2[11];
    char str3[11];
    int i, len;

    len = strlen(str); // Get the length of the string

    // Copy str to str2
    strcpy(str2, str);

    // First loop: Perform bitwise AND with 127
    for (i = 0; i < len; i++) 
    {
        str1[i] = str[i] & 127;
        printf("%c", str1[i]);
    }
    printf("\n");

    // Second loop: Perform bitwise XOR with 127
    for (i = 0; i < len; i++) 
    {
        str3[i] = str2[i] ^ 0;
        printf("%c", str3[i]);
    }
    printf("\n");
}

// Output:
// Hello World
// Hello World
// Hello World
 