SELECT floor(price/10000)*10000, count(*)
FROM product
GROUP BY floor(price/10000)
ORDER BY 1;