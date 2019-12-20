/*
typedef short Box[3];

void BoxSetDimensions(Box, short, short, short);
int BoxGetVolume(Box);
*/

typedef short Box[4];

void BoxSetDimensions(Box, short, short, short);
void BoxSetThickness(Box, short);
int BoxGetVolume(Box);

