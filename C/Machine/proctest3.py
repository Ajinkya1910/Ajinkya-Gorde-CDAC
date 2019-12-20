from ctypes import *

lib = CDLL('./myccproc.so')
a = input('First number : ')
b = input('Second number: ')
c = input('Thied number : ')

print 'G.C.D =', lib.GCD(a, b, c, 0)

