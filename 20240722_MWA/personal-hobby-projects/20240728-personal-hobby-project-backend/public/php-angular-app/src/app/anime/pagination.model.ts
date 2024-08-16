export class Pagination {
  page: number;
  size: number;
  total: number;
  hasNext: boolean;
  hasPrevious: boolean;

  constructor(page: number = 1, size: number = 10, total: number = 10, hasNext: boolean = false, hasPrevious: boolean = false) {
    this.page = page;
    this.size = size;
    this.total = total;
    this.hasNext = hasNext;
    this.hasPrevious = hasPrevious;
  }
}
