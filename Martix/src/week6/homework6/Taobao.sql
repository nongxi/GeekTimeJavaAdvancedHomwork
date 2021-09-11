CREATE TABLE TUser(
    UserNumber int (8) NOT NULL,
    Nickname VARCHAR(10),
    MobileNumber int (13) NOT NULL,
    Email VARCHAR(20) NOT NULL,
    CreateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    MemberShip boolean NOT NULL DEFAULT 0,
    PRIMARY KEY(UserNumber)
);

CREATE TABLE TProduct(
    ProductNumber int(8) NOT NULL,
    ProductName VARCHAR(20) NOT NULL,
    ProductSize VARCHAR(20),
    InputStoreHouseTime TIMESTAMP  NOT NULL,
    OutputStoreHouseTime TIMESTAMP  NOT NULL,
    ProductTime CURRENT_DATE NOT NULL,
    ProductCarCode int(13) NOT NULL,
    ProductSourceCompany VARCHAR(20) NOT NULL
);

CREATE TABLE TOrder(
    OrderNumber int(20) NOT NULL,
    BuyerName VARCHAR(20) NOT NULL, --NickName
    ReciveAddress VARCHAR(20),
    BuyerMobieNumber int(13) NOT NULL,
    CreateTime TIMESTAMP  NOT NULL,
    SendProductTime TIMESTAMP  NOT NULL,
    ReceiveProductTime TIMESTAMP  NOT NULL,
    ProductNumber int(8) NOT NULL,
    ProductCarCode int(13) NOT NULL
);