SELECT B.TITLE                   
        , B.BOARD_ID               
        , R.REPLY_ID                 
        , R.WRITER_ID              
        , R.CONTENTS             
        , TO_CHAR(R.CREATED_DATE,'YYYY-MM-DD') AS CREATED_DATE  
FROM USED_GOODS_BOARD B 
        INNER JOIN USED_GOODS_REPLY R
        ON B.BOARD_ID = R.BOARD_ID
WHERE TO_CHAR(B.CREATED_DATE,'YYYYMM') = '202210'       
ORDER BY R.CREATED_DATE, B.TITLE                                     