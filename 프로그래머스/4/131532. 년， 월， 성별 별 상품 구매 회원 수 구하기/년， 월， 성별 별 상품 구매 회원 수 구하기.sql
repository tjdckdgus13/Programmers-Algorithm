SELECT
    TO_CHAR(OS.SALES_DATE,'YYYY') AS YEAR, 
    TO_NUMBER(TO_CHAR(SALES_DATE, 'MM')) AS MONTH, 
    UI.GENDER, 
    COUNT(DISTINCT UI.USER_ID) AS USERS
FROM
    USER_INFO UI
JOIN
    ONLINE_SALE OS ON UI.USER_ID = OS.USER_ID
WHERE
    GENDER IS NOT NULL
GROUP BY
    TO_CHAR(OS.SALES_DATE,'YYYY'), 
    TO_CHAR(OS.SALES_DATE,'MM'), 
    GENDER
ORDER BY
    YEAR, 
    MONTH, 
    GENDER;