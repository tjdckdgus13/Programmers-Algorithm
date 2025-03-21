SELECT MP.MEMBER_ID, MP.MEMBER_NAME, MP.GENDER, TO_CHAR(MP.DATE_OF_BIRTH, 'YYYY-MM-DD')
FROM MEMBER_PROFILE MP
WHERE TO_CHAR(MP.DATE_OF_BIRTH, 'MM') = '03' 
AND MP.TLNO IS NOT NULL AND MP.GENDER = 'W'
ORDER BY MP.MEMBER_ID ASC;