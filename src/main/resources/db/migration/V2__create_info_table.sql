-- ImageUploadInfo 테이블 생성
CREATE TABLE image_upload_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL, -- Post 테이블과 연관된 외래 키
    image_name VARCHAR(255) NOT NULL,
    image_path VARCHAR(255) NOT NULL,
    seq INT NOT NULL,
    FOREIGN KEY (post_id) REFERENCES post(id) ON DELETE CASCADE
);

-- PostUploadInfo 테이블 생성
CREATE TABLE post_upload_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL, -- User 테이블과 연관된 외래 키
    content TEXT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
);
