int add(int a, int b)  {
	int c;
	c = a+b[0];
	return c;
}

void main() {
	int d = 5;
	int b;
	int c[10];
	d = 3;
	for(b = 1; b<10; b++) {
		_print(10);
	}
	while(b != 15) {
		b++;
	}
	if(b != 5) {
		_print(b);
	}
	else {
		_print(d);
	}
	for(int i=0; i<5; i++) {
		c[i] = i;
		_print(c[i]);
	}
	add(1,c);
}
