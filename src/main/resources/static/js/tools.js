/**
 * 时间格式校验（严格匹配yyyy-MM-dd HH:mm）
 * @param {string} timeStr - 待校验的时间字符串
 * @returns {boolean} 校验结果（true=格式正确且日期合法）
 */
function checkTimeFormat(timeStr) {
    // 正则匹配格式
    const timeReg = /^(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2})$/;
    if (!timeReg.test(timeStr)) return false;

    // 解析时间字段
    const [year, month, day, hour, minute] = timeStr.split(/[- :]/).map(Number);

    // 校验日期合法性（处理2月、30/31天等特殊情况）
    const date = new Date(year, month - 1, day, hour, minute);
    return (
        date.getFullYear() === year &&
        date.getMonth() === month - 1 &&
        date.getDate() === day &&
        date.getHours() === hour &&
        date.getMinutes() === minute
    );
}

/**
 * 生成唯一预约记录ID（时间戳+随机数，确保不重复）
 * @returns {string} 唯一ID（格式：时间戳_随机数，如"1730000000000_123"）
 */
function generateReserveId() {
    const timestamp = Date.now(); // 毫秒级时间戳（确保时序唯一）
    const random = Math.floor(Math.random() * 1000); // 0-999随机数（避免同一毫秒重复）
    return `${timestamp}_${random}`;
}

/**
 * 学生信息输入校验（前端前置校验，减少后端无效请求）
 * @param {Object} student - 学生信息对象（含studentId、name、gender等字段）
 * @returns {boolean} 校验结果（true=校验通过）
 */
function checkStudentInput(student) {
    // 1. 校验必填字段
    const requiredFields = [
        { key: 'studentId', name: '学号' },
        { key: 'name', name: '姓名' },
        { key: 'gender', name: '性别' },
        { key: 'college', name: '学院' },
        { key: 'phone', name: '联系电话' },
        { key: 'birthday', name: '生日' }
    ];
    for (const field of requiredFields) {
        const value = student[field.key]?.trim();
        if (!value) {
            alert(`请填写完整的${field.name}！`);
            return false;
        }
    }

    // 2. 校验手机号格式（11位数字，以13-9开头）
    const phoneReg = /^1[3-9]\d{9}$/;
    if (!phoneReg.test(student.phone.trim())) {
        alert('联系电话格式错误！请输入11位有效手机号（如13800138000）');
        return false;
    }

    // 3. 校验生日格式（yyyy-MM-dd，兼容浏览器date输入框）
    const birthdayReg = /^(\d{4})-(\d{2})-(\d{2})$/;
    if (!birthdayReg.test(student.birthday)) {
        alert('生日格式错误！请选择正确的日期（格式为yyyy-MM-dd）');
        return false;
    }

    return true;
}

/**
 * 文件下载工具（支持JSON/XML/TXT等格式，适配记录导出需求）
 * @param {string} content - 文件内容
 * @param {string} fileName - 文件名（如"consult_records_20241201.json"）
 * @param {string} contentType - 文件MIME类型（如"application/json"）
 */
function downloadFile(content, fileName, contentType) {
    // 创建Blob对象（二进制数据容器）
    const blob = new Blob([content], { type: contentType });

    // 创建下载链接
    const url = URL.createObjectURL(blob);
    const aTag = document.createElement('a');
    aTag.href = url;
    aTag.download = fileName; // 设置下载文件名

    // 模拟点击下载（解决部分浏览器不触发下载的问题）
    document.body.appendChild(aTag);
    aTag.click();

    // 清理资源（避免内存泄漏）
    setTimeout(() => {
        document.body.removeChild(aTag);
        URL.revokeObjectURL(url);
    }, 100);
}
