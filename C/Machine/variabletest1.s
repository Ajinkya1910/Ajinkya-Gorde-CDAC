	.intel_syntax noprefix
	.include "console.i"

	.data
count:	.quad	0
total:	.quad	0

	.text
ask:	.asciz	"Count: "
ans:	.asciz	"Total = "

_entry:
	PutMsg	ask
	GetInt	count		#n

	mov	rax, count	#rax=n
	mov	rbx, rax	#rbx=n
	add	rbx, 1		#rbx=n+1
	mul	rbx		#rax=n*(n+1)
	shr	rax, 1		#rax=n*(n+1)/2
	mov	total, rax

	PutMsg	ans
	PutInt	total
	PutEoL

	ret

	.global	_entry
	.end

