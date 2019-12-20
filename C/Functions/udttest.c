#include <stdio.h>

enum Course {Elementary, Intermediate, Advanced};

struct Student
{
	int id;
	enum Course level;
	union
	{
		char grade;
		float score;
	};
};

float StudentGetPoints(struct Student candidate)
{
	float points;

	switch(candidate.level)
	{
	case Elementary:
		points = 100 + 20 * ('F' - candidate.grade);
		break;
	case Intermediate:
		points = 150 + 3 * (candidate.score - 50);
		break;
	default:
		points = 200 + 4 * (candidate.score - 50);
	}

	return points;
}


int main(void)
{
	struct Student jack = {23, Elementary, 'D'};
	struct Student jill;
	jill.id = 32;
	jill.level = Advanced;
	jill.score = 65;

	printf("Student with ID %d has earned %.1f points\n", jack.id, StudentGetPoints(jack));
	printf("Student with ID %d has earned %.1f points\n", jill.id, StudentGetPoints(jill));
}


