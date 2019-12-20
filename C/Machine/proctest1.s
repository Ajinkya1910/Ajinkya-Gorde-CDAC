	.intel_syntax noprefix
	.include "console.i"

	.data
first:	.quad	0
second:	.quad	0
result:	.quad	0

	.text
ask:	.asciz	"Positive Number: "
ans:	.asciz	"G.C.D = "

_entry:
	mov	rbp, rsp
	sub	rsp, 24

	PutMsg	ask
	GetInt	[rbp-8]		#first
	PutMsg	ask
	GetInt	[rbp-16]	#second

	mov	rax, [rbp-8]
	mov	rdx, [rbp-16]
	call	_GCD
	mov	[rbp-24], rax	#result

	PutMsg	ans
	PutInt	[rbp-24]
	PutEoL

	mov	rsp, rbp	#unwinding stack frame
	ret

	.global	_entry
	.end

