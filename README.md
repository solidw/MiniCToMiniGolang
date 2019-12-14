# MiniCToMiniGolang
CNU CSE 3-2 Compiler introduction final assignment



본 과제는 MiniCToBytecode Compiler => MiniCToMiniGolang Transpiler로 변환하는 것을 목표로 한다.

201701972 고태완



## Feature

> ##### MiniC → MiniGo Transpiling

- ####  MiniC

  - Data type : void, int, int[LITERAL] only
  - Statement : for, while, if, else ( no else if ), return, binaryOP( AND, OR, +, -... But No Bit OP )
  - Functions ( builtin Function _print() : puts() in C )
  - The other keyword in C are dosen't exist in MiniC ( struct, typedef ... )

  

- #### MiniGo

  - Data type : int, int Slice ( make([]int, LITERAL ), ( No int Array ) )
  - Statement : for, if, else,  return, binaryOP
  - Functions
  - The other keyword in Golang are dosen't exist in MiniGolang ( const, goto, switch... )
  - NO ++IDENT in Basic Golang

- Smart Indenting when transpiling MiniC to MiniGolang

- Additional Implemantaion : for, IDENT ++ in MiniC

- Default package 'main' in MiniGolang

- Apply default syntax which is prefer in Golang ( a+b => a + b, if  {} \n else => if {} else )