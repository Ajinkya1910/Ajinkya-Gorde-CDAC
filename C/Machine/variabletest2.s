	.intel_syntax	noprefix
	.include	"console.i"
	
	.data
list:	.quad	1, 4, 9, 16, 25, 36, 49, 64, 81
index:	.quad	0
value:	.quad	0

	.text
ask:	.asciz	"Index [0-8]: "
ans:	.asciz	"Value = "

_entry:
	PutMsg	ask
	GetInt	index

	lea	rdi, list
	mov	rsi, index	#direct addressing
	mov	rax, [rdi+8*rsi] #indirect addressing (indirection)
	mov	value, rax

	PutMsg	ans
	PutInt	value
	PutEoL

	ret

	.global	_entry
	.end

