# Kafka
## Kafka will remove ZooKeeper
- Truoc phien ban 3.6 **ZooKeeper** rat quan trong de quan ly **clusters**
- Phien ban 3.6 **Kafka** da su dungj **KRaft metadata system** de quan ly **clusters**
- Du kien tu phien ban 4.0 **Kafka** se loai bo hoan toan **ZooKeeper**

## Install
- install by `docker-compose.yml` file
```shell
    docker-compose up -d
```

## Documents
### Group
- **Group** la de khi service chay trong **kubernetes cluster** co the co **nhieu instances** 
  - thi luc do no se dieu phoi **gui message cho tung instance**
  - chu neu chay nhieu instance ma **khong co group** thi **message do se duoc gui den tat ca cac instance** dan den duplicate
- Voi 1 **topic** neu 2 instance config 2 **group** listen thi ca 2 instance deu nhan duoc message
  - ex 1 instance listen **topic** voi group1 sau do sua thanh group2 thi tiep tuc nhan duoc message