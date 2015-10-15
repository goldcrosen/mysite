
SELECT * FROM member;
 
 --insert
 INSERT INTO MEMBER(NO,NAME,EMAIL,PASSWORD,GENDER)
             VALUES(MEMBER_NO_SEQ.NEXTVAL, '±ËªÛ»∆', 'GoldCrosen@gmail.com', '1234', 'mail' );
             
commit;

UPDATE MEMBER SET GENDER = 'MALE'
WHERE NO = 1;

--select(login)
SELECT NO, NAME, EMAIL FROM MEMBER
WHERE EMAIL='GoldCrosen@gmail.com'
AND PASSWORD='1234';

