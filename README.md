## Created by Notification Team ##

# Repeated Lines Remover  #

#How to Use:

Este programa foi criado com o objetivo de automatização da tarefa de insersão de exames, oriundos do Gliese, na tabela 
<b>Progress_Exam</b>.

Uma vez que você tenha obtido os exames necessários, oriundos da consulta no banco do Gliese (exemplo abaixo), será necessário copiar os 
registros para um arquivo (trabalhei com o Atom mas você poderá utilizar a IDE de sua preferência).

    select DISTINCT --EKI."ExaK2ExtInv_codEmpresa",
    EKI."ExaK2ExtInv_mnmExa",
    EKI."ExaK2ExtInv_mnmExaExt",
    --EKI."ExaK2ExtInv_mnmExaLegado",
    EXACOD."Exa_nome"
    from "ExaK2ExtInv" EKI, "Exa" EXACOD
    where EKI."ExaK2ExtInv_dtRef" in(select max(EKI2."ExaK2ExtInv_dtRef")
                                     from "ExaK2ExtInv" EKI2
                                     where EKI2."ExaK2ExtInv_mnmExaLegado" = EKI."ExaK2ExtInv_mnmExaLegado"
                                     and EKI2."ExaK2ExtInv_codEmpresa" = EKI."ExaK2ExtInv_codEmpresa")
    AND EKI."ExaK2ExtInv_codEmpresa" IN (31,32,10,16,17,54)
    --AND EKI."ExaK2ExtInv_mnmExaLegado" LIKE 'RACD'
    AND EXACOD."Exa_nome" LIKE 'RM%'
    AND EKI."ExaK2ExtInv_mnmExa" = EXACOD."Exa_codigo";

<b>OBS</b>: Ao copiar e colar todos os registro - resultado da consulta no Gliese - será necessário retirar todos os ID's,
que virão na frente de cada linha/registro:


Ex: 
<b>ANTES:</b>
- 17	PCRUSSA	ZPCRTDSA	ZPCRTD	PROTEINA C REATIVA ULTRA-SENSIVEL
- 17	LM-DCUO2IM	DCUO2	DCUO2	ULTRA SOM OBSTETRICO COM DOPPLER COLLOR
- 17	LM-UABTFIM	UABTF	UABTF	ULTRA ABDOMEM TOTAL-INCLUI ABD. INFERIOR
- 17	LM-UBETIM	UBET	UBET	ULTRA SOM TESTICULOS

<b>DEPOIS:</b>
- PCRUSSA	ZPCRTDSA	ZPCRTD	PROTEINA C REATIVA ULTRA-SENSIVEL
- LM-DCUO2IM	DCUO2	DCUO2	ULTRA SOM OBSTETRICO COM DOPPLER COLLOR
- LM-UABTFIM	UABTF	UABTF	ULTRA ABDOMEM TOTAL-INCLUI ABD. INFERIOR
- LM-UBETIM	UBET	UBET	ULTRA SOM TESTICULOS


Depois que os todos os id's forem retirados, salvar o arquivo com extenção txt e colocá-lo dentro do packge <i>file</i>
Ao final, rode o método Main e o resultado da transfomação sairá no console.