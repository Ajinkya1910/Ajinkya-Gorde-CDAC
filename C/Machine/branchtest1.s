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
	mov	rsi, index	
	cmp	rsi, 8
	ja	1f
	mov	rax, [rdi+8*rsi]
	mov	value, rax

	PutMsg	ans
	PutInt	value
	PutEoL

1:	ret

	.global	_entry
	.end

