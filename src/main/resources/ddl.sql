CREATE TABLE `member` (
  `member_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '회원번호',
  `member_name` varchar(255) DEFAULT NULL COMMENT '회원이름',
  `member_alias` varchar(20) NOT NULL DEFAULT '' COMMENT '별명',
  `passwd` varchar(256) NOT NULL DEFAULT '' COMMENT '비밀번호',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '전화번호',
  `email` varchar(60) NOT NULL DEFAULT '' COMMENT '이메일',
  `gender` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '성별(1:남자, 2:여자)',
  `created_at` timestamp NOT NULL COMMENT '생성시간',
  `updated_at` timestamp NOT NULL COMMENT '수정시간',
  PRIMARY KEY (`member_id`),
  KEY `idx_alias` (`member_alias`),
  KEY `idx_email` (`passwd`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='회원정보';

CREATE TABLE `product` (
   `product_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '제품번호',
   `product_name` varchar(60) NOT NULL DEFAULT '' COMMENT '제품명',
   `created_at` timestamp NOT NULL COMMENT '생성시간',
   `updated_at` timestamp NOT NULL COMMENT '수정시간',
   PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='상품정보';

CREATE TABLE `product_order` (
 `order_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '주문번호',
 `member_id` int(11) unsigned NOT NULL COMMENT '회원번호',
 `product_id` int(11) unsigned NOT NULL COMMENT '제품번호',
 `paid_at` timestamp NOT NULL COMMENT '결제시간',
 `last_order` tinyint(1) unsigned DEFAULT '1' COMMENT '마지막주문여부',
 `created_at` timestamp NOT NULL COMMENT '생성시간',
 `updated_at` timestamp NOT NULL COMMENT '수정시간',
 PRIMARY KEY (`order_id`),
 KEY `idx_member_product` (`member_id`,`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='주문정보';