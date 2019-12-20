	.intel_syntax	noprefix
	.text

_GCD:
1:	cmp	rax, rdx
	je	3f
	ja	2f

	sub	rdx, rax
	jmp	1b

2:	sub	rax, rdx
	jmp	1b

3:	ret

	.global	_GCD
	.end


	

