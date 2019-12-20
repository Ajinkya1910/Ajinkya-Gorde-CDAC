	.intel_syntax noprefix
	.include "console.i"

	.macro	Abs reg
		mov	rdx, \reg
		neg	rdx
		cmovg	\reg, rdx
	.endm

	.macro	Mul10 reg
		add	\reg, \reg
		mov	rdx, \reg
		add	rdx, rdx
		add	rdx, rdx
		add	\reg, rdx
	.endm

	.data
number:	.quad	0
digits:	.quad	0

	.text
ask:	.asciz	"Number: "
ans:	.asciz	"Digits = "

_entry:
	PutMsg	ask
	GetInt	number

	mov	rax, 1
	mov	rbx, number
	Abs	rbx
	mov	rcx, 0

1:	Mul10	rax
	inc	rcx

	cmp	rax, rbx
	jbe	1b

	mov	digits, rcx

	PutMsg	ans
	PutInt	digits
	PutEoL

	ret

	.global	_entry
	.end

