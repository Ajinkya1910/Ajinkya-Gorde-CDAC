	.file	"syssvctest.c"
	.intel_syntax noprefix
	.text
	.globl	PowerPause
	.type	PowerPause, @function
PowerPause:
.LFB0:
	.cfi_startproc
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	mov	DWORD PTR [rbp-20], edi
	mov	eax, DWORD PTR [rbp-20]
	mov	DWORD PTR [rbp-16], eax
	mov	DWORD PTR [rbp-12], 0
	mov	eax, 35
	lea	rdx, [rbp-16]
	mov	rdi, rdx
#APP
# 6 "syssvctest.c" 1
	syscall
# 0 "" 2
#NO_APP
	pop	rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	PowerPause, .-PowerPause
	.section	.rodata
.LC0:
	.string	"Hello"
.LC1:
	.string	"Goodbye"
	.text
	.globl	main
	.type	main, @function
main:
.LFB1:
	.cfi_startproc
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	push	rbx
	sub	rsp, 24
	.cfi_offset 3, -24
	mov	DWORD PTR [rbp-20], edi
	mov	QWORD PTR [rbp-32], rsi
	mov	edi, OFFSET FLAT:.LC0
	call	puts
	mov	ebx, 1
	jmp	.L3
.L4:
	movsx	rax, ebx
	lea	rdx, [0+rax*8]
	mov	rax, QWORD PTR [rbp-32]
	add	rax, rdx
	mov	rax, QWORD PTR [rax]
	mov	rdi, rax
	call	puts
	mov	edi, ebx
	call	PowerPause
	add	ebx, 1
.L3:
	cmp	ebx, DWORD PTR [rbp-20]
	jl	.L4
	mov	edi, OFFSET FLAT:.LC1
	call	puts
	add	rsp, 24
	pop	rbx
	pop	rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1:
	.size	main, .-main
	.ident	"GCC: (GNU) 4.8.5 20150623 (Red Hat 4.8.5-36)"
	.section	.note.GNU-stack,"",@progbits
