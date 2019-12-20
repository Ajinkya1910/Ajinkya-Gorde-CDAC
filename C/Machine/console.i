####################################################################
# Name          : console.i
# Description   : Defines macros for calling input/output procedures
#                 implemented in system.o for linux x86-64
# Author        : K.M.Hussain
# Licence       : Educational
####################################################################


.extern _writestr, _writestz, _writelfc, _writeint, _readstr, _readint

# PutStr - Outputs a string with address in value and size in len.
.macro  PutStr  value, len
    mov     %rdx, \value
    mov     %ecx, \len
    call    _writestr
.endm

# PutMsg - Outputs a null terminated string identified by label in value.
.macro  PutMsg  value
    mov     %rdx, offset \value
    call    _writestz
.endm

# PutEOL - Outputs an end-of-line character
.macro  PutEOL
    call    _writelfc
.endm

# GetStr - Inputs a string in buffer with address in value and size in len.
.macro  GetStr  value, len
    mov     %rdx, \value
    mov     %ecx, \len
    call    _readstr
.endm

# PutInt - Outputs an integer value of specified length in decimal format.
.macro  PutInt  value, len=8
    .ifeq \len-8
    mov     %rax, qword ptr[\value]
    .endif
    .ifeq \len-4
    movsxd  %rax, dword ptr[\value]
    .endif
    .ifeq \len-2
    movsx  %rax, word ptr[\value]
    .endif
    .ifeq \len-1
    movsx  %rax, byte ptr[\value]
    .endif

    call    _writeint
.endm

# GetInt - Inputs in decimal format an integer of specified length into value 
# and clears or sets ZF if successful or failed.
.macro  GetInt  value, len=8
    call    _readint
    .ifeq \len-8
    mov     qword ptr[\value], %rax
    .endif
    .ifeq \len-4
    mov     dword ptr[\value], %eax
    .endif
    .ifeq \len-2
    mov     word ptr[\value], %ax
    .endif
    .ifeq \len-1
    mov     byte ptr[\value], %al
    .endif
.endm


