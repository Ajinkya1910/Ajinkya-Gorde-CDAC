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

GCD:	
	pop	r10		#save return-address in r10
	push	r9
	push	r8
	push	rcx
	push	rdx
	push	rsi
	push	rdi

	mov	rax, [rsp]
	sub	rsi, rsi	#rsi=0
1:	inc	rsi
	mov	rdx, [rsp+8*rsi]
	test	rdx, rdx	
	jz	2f
	call	_GCD
	jmp	1b

2:	add	rsp, 48
	push	r10		#restore return-address
	ret

	.global	GCD
	.type	GCD, @function
	.end


	

